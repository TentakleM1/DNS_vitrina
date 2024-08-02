import { useState } from 'react'

function App() {
  const [count, setCount] = useState('Not text server')

  const handle = async () => {
    console.log('work')
    try {
      const response = await fetch("http://localhost:9090/login", {
        method: 'GET'
      })

      if (!response.ok) {
        throw new Error(`Error! status: ${response.status}`);
      }

      const result = await response.json();

      setCount(JSON.stringify(result))

    } catch (error) {
      throw new Error(`Error: not workig GET: ${error}`)
    }
  }

  return (
    <>
      <div>
        <h1>{count}</h1>
      </div>
      <div className="card">
        <button onClick={handle}>
          GET FOR SERVER
        </button>
      </div>
    </>
  )
}

export default App
