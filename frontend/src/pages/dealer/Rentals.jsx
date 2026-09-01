import { dealerRentals } from '../../data/mockData'

export default function Rentals() {
  return (
    <div className="page">
      <h1>Rentals</h1>
      <div className="card-container">
        {dealerRentals.map((rental) => (
          <div key={rental.id} className="card">
            <h3>{rental.equipmentName}</h3>
            <p><strong>Customer:</strong> {rental.customerId}</p>
            <p><strong>Period:</strong> {rental.rentalStart} to {rental.rentalEnd}</p>
            <p><strong>Daily Rate:</strong> ${rental.dailyRate}</p>
            <p><strong>Status:</strong> <span className={`badge badge-${rental.status}`}>{rental.status}</span></p>
          </div>
        ))}
      </div>
    </div>
  )
}
