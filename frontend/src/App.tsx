import { useEffect, useState } from 'react'
import { fetchBackendHealth } from './api/health'

type ConnectionState = 'checking' | 'connected' | 'disconnected'

function App() {
  const [connectionState, setConnectionState] = useState<ConnectionState>('checking')
  const [serviceName, setServiceName] = useState<string | null>(null)

  useEffect(() => {
    let isMounted = true

    fetchBackendHealth()
      .then((data) => {
        if (!isMounted) return
        setConnectionState('connected')
        setServiceName(data.service)
      })
      .catch(() => {
        if (!isMounted) return
        setConnectionState('disconnected')
      })

    return () => {
      isMounted = false
    }
  }, [])

  return (
    <main style={styles.page}>
      <h1 style={styles.title}>Smart Rental Tracking System</h1>
      <p style={styles.subtitle}>Project foundation is running.</p>

      <div style={styles.statusBox}>
        {connectionState === 'checking' && <span>Checking backend connection...</span>}
        {connectionState === 'connected' && (
          <span style={styles.connected}>
            Backend: Connected{serviceName ? ` (${serviceName})` : ''}
          </span>
        )}
        {connectionState === 'disconnected' && (
          <span style={styles.disconnected}>
            Backend: Disconnected (could not reach http://localhost:8080/api/health)
          </span>
        )}
      </div>
    </main>
  )
}

const styles: Record<string, React.CSSProperties> = {
  page: {
    minHeight: '100vh',
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    justifyContent: 'center',
    fontFamily: 'system-ui, sans-serif',
    textAlign: 'center',
    padding: '2rem',
  },
  title: {
    fontSize: '2rem',
    marginBottom: '0.5rem',
  },
  subtitle: {
    color: '#555',
    marginBottom: '2rem',
  },
  statusBox: {
    padding: '0.75rem 1.25rem',
    borderRadius: '8px',
    border: '1px solid #ddd',
    fontSize: '0.95rem',
  },
  connected: {
    color: '#0a7a2f',
    fontWeight: 600,
  },
  disconnected: {
    color: '#b3261e',
    fontWeight: 600,
  },
}

export default App
