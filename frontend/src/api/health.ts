export interface HealthResponse {
  status: string
  service: string
}

const BACKEND_HEALTH_URL = 'http://localhost:8080/api/health'

/**
 * Calls the backend health endpoint.
 * Throws if the backend is unreachable or returns a non-OK response.
 */
export async function fetchBackendHealth(): Promise<HealthResponse> {
  const response = await fetch(BACKEND_HEALTH_URL)

  if (!response.ok) {
    throw new Error(`Backend responded with status ${response.status}`)
  }

  return (await response.json()) as HealthResponse
}
