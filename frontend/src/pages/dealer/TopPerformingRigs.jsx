import { topPerformingRigs } from '../../data/mockData'

export default function TopPerformingRigs() {
  return (
    <div className="page">
      <h1>Top Performing Rigs</h1>
      <div className="card-container">
        {topPerformingRigs.map((rig) => (
          <div key={rig.id} className="card">
            <h3>{rig.equipmentName}</h3>
            <p><strong>Rental Days:</strong> {rig.totalRentalDays}</p>
            <p><strong>Total Revenue:</strong> ${rig.totalRevenue.toLocaleString()}</p>
            <p><strong>Utilization Rate:</strong> {rig.utilizationRate}%</p>
            <p><strong>Avg Rating:</strong> ⭐ {rig.avgRating}/5</p>
          </div>
        ))}
      </div>
    </div>
  )
}
