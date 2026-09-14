import React, { useEffect, useState } from 'react';
import { createRoot } from 'react-dom/client';
import './styles.css';

const api = 'http://localhost:8080/api/v1';

function App() {
  const [page, setPage] = useState('home');
  const [categories, setCategories] = useState([]);
  const [questions, setQuestions] = useState([]);
  const [questionIndex, setQuestionIndex] = useState(0);
  const [assessment, setAssessment] = useState(null);
  const [selectedOption, setSelectedOption] = useState(null);
  const [results, setResults] = useState([]);
  const [routes, setRoutes] = useState([]);
  const [error, setError] = useState('');

  useEffect(() => { fetch(`${api}/categories`).then(r => r.json()).then(setCategories).catch(() => setError('CareerGPS is unavailable. Start the backend and try again.')); }, []);
  async function beginJourney() {
    try {
      const profile = await fetch(`${api}/assessments`, { method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify({currentClass: 'Class 10', stream: 'Not selected yet', age: 15}) }).then(r => r.json());
      const loadedQuestions = await fetch(`${api}/questions`).then(r => r.json());
      setAssessment(profile); setQuestions(loadedQuestions); setQuestionIndex(0); setSelectedOption(null); setPage('journey');
    } catch { setError('Could not start your journey. Please try again.'); }
  }
  async function nextQuestion() {
    if (!selectedOption) return setError('Choose one answer to continue.');
    setError('');
    const question = questions[questionIndex];
    await fetch(`${api}/assessments/${assessment.assessmentId}/answers`, { method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify({questionId: question.questionId, optionId: selectedOption}) });
    if (questionIndex + 1 < questions.length) { setQuestionIndex(questionIndex + 1); setSelectedOption(null); return; }
    const matches = await fetch(`${api}/assessments/${assessment.assessmentId}/results`).then(r => r.json()); setResults(matches); setPage('results');
  }
  async function showMap(careerId) { setRoutes(await fetch(`${api}/careermap/${careerId}`).then(r => r.json())); setPage('map'); }
  const question = questions[questionIndex];
  return <main><header><button className="brand" onClick={() => setPage('home')}>⌁ CareerGPS</button><nav><button onClick={() => setPage('explore')}>Explore</button><button onClick={beginJourney}>Journey</button></nav><button className="primary" onClick={beginJourney}>Start journey</button></header>
    {error && <p className="error" role="alert">{error}</p>}
    {page === 'home' && <section className="hero"><div><p className="eyebrow">Your future, made clearer</p><h1>Find your path.<br/>Build your future.</h1><p>Explore careers, understand real education routes, and take one clear next step after Class 10 or 12.</p><button className="primary" onClick={beginJourney}>Start journey →</button><button className="secondary" onClick={() => setPage('explore')}>Explore careers</button></div><CareerMapPreview /></section>}
    {page === 'explore' && <section><p className="eyebrow">Explore mode · 2–3 minutes</p><h2>Discover career areas</h2><p>Browse first. There is no right or wrong choice.</p><div className="grid">{categories.map(c => <article className="card" key={c.categoryId}><span>⌁</span><h3>{c.name}</h3><p>{c.description}</p></article>)}</div></section>}
    {page === 'journey' && question && <section className="question"><div className="progress"><span>Question {questionIndex + 1} of {questions.length}</span><div><i style={{width: `${((questionIndex + 1) / questions.length) * 100}%`}}/></div></div><p className="eyebrow">{question.questionType.replace('_', ' ')}</p><h2>{question.questionText}</h2>{question.options.map(option => <button className={`option ${selectedOption === option.optionId ? 'selected' : ''}`} key={option.optionId} onClick={() => setSelectedOption(option.optionId)}><b>○</b>{option.optionText}</button>)}<button className="primary" onClick={nextQuestion}>Continue</button></section>}
    {page === 'results' && <section><p className="eyebrow">Your results</p><h2>Careers worth exploring</h2><p>These are suggestions, not decisions. You choose what to explore next.</p><div className="grid">{results.map(result => <article className="card match" key={result.careerId}><p className="label">{result.matchLevel}</p><h3>{result.careerName}</h3><p>{result.description}</p><ul>{result.reasons.map(reason => <li key={reason}>{reason}</li>)}</ul><button className="secondary" onClick={() => showMap(result.careerId)}>View CareerMap</button></article>)}</div></section>}
    {page === 'map' && <section><p className="eyebrow">CareerMap</p><h2>Possible education routes</h2><p>Every route has trade-offs. Compare them with your family or teacher.</p><div className="routes">{routes.map(route => <article className="route" key={route.routeId}><h3>{route.routeName}</h3><p>{route.routeDescription}</p><ol className="steps">{route.steps?.map(step => <li key={step.stepOrder}><strong>{step.title}</strong><span>{step.detail}</span></li>)}</ol><p className="route-meta">{route.durationMonths && `${route.durationMonths / 12} years · `}{route.costBand || 'Cost varies'}{route.entranceExams && ` · Exams: ${route.entranceExams}`}</p></article>)}</div></section>}
  </main>;
}
function CareerMapPreview() { return <aside className="preview"><p className="eyebrow">CareerMap preview</p><h3>Software Engineer</h3><ol><li>Class 10</li><li>Science with PCM</li><li>B.Tech / Diploma route</li><li>Software Engineer</li></ol><p className="note">Two routes available — compare before deciding.</p></aside>; }
createRoot(document.getElementById('root')).render(<App />);
