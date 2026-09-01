import { customerEquipment } from '../../data/mockData'

export default function MyEquipment() {
  return (
    <div className="page">
      <h1>My Equipment</h1>
      <div className="card-container">
        {customerEquipment.map((equipment) => (
          <div key={equipment.id} className="card">
            <h3>{equipment.equipmentName}</h3>
            <p><strong>Rental Period:</strong> {equipment.rentalStart} to {equipment.rentalEnd}</p>
            <p><strong>Days Remaining:</strong> {equipment.daysRemaining}</p>
            <p><strong>Cost per Day:</strong> ${equipment.costPerDay}</p>
            <p><strong>Status:</strong> <span className={`badge badge-${equipment.status}`}>{equipment.status}</span></p>
          </div>
        ))}
      </div>
    </div>
  )
}
