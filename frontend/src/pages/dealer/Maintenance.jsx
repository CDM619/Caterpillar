import { dealerMaintenance } from '../../data/mockData'

export default function Maintenance() {
  return (
    <div className="page">
      <h1>Maintenance</h1>
      <div className="card-container">
        {dealerMaintenance.map((item) => (
          <div key={item.id} className="card">
            <h3>{item.equipmentName}</h3>
            <p><strong>Last Service:</strong> {item.lastServiceDate}</p>
            <p><strong>Next Service Due:</strong> {item.nextServiceDue}</p>
            <p><strong>Hours:</strong> {item.maintenanceHours}</p>
            <p><strong>Status:</strong> <span className={`badge badge-${item.status}`}>{item.status}</span></p>
          </div>
        ))}
      </div>
    </div>
  )
}
