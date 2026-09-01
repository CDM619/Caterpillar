export default function RequestNewRig() {
  return (
    <div className="page">
      <h1>Request New Rig</h1>
      <div className="card">
        <form>
          <div className="form-group">
            <label htmlFor="equipmentType">Equipment Type</label>
            <input type="text" id="equipmentType" placeholder="e.g., Excavator, Loader, Crane" />
          </div>
          <div className="form-group">
            <label htmlFor="capacity">Capacity/Specifications</label>
            <input type="text" id="capacity" placeholder="e.g., 50 tons, 320D" />
          </div>
          <div className="form-group">
            <label htmlFor="rentalStart">Rental Start Date</label>
            <input type="date" id="rentalStart" />
          </div>
          <div className="form-group">
            <label htmlFor="rentalEnd">Rental End Date</label>
            <input type="date" id="rentalEnd" />
          </div>
          <div className="form-group">
            <label htmlFor="purpose">Purpose/Project Details</label>
            <textarea id="purpose" placeholder="Describe your project..." rows="4"></textarea>
          </div>
          <button type="submit" className="btn btn-primary">Submit Request</button>
        </form>
      </div>
    </div>
  )
}
