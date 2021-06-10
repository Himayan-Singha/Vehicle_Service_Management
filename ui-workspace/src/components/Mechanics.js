export function Mechanics() {
  return (
    <div className="row" style={{ marginTop: "30px" }}>
      <div className="col-3 col-md-3 d-none d-md-block"></div>
      <div className="col-12 col-md-6">
        <h3 className="alert alert-warning">Mechanic Registration</h3>
        <div className="alert alert-success">Mechanic details Added</div>
        <div className="mb-1">
          <input
            type="text"
            //value={firstName}
            // onChange={(e) => updateFirstName(e)}
            className="form-control"
            placeholder="Enter Name"
          />
        </div>
        <div className="mb-1">
          <input
            type="number"
            //value={lastName}
            // onChange={(e) => updateLastName(e)}
            className="form-control"
            placeholder="Enter Age"
          />
        </div>
        <div className="mb-1">
          <input
            type="text"
            //value={userName}
            //onChange={(e) => updateUserName(e)}
            className="form-control"
            placeholder="Enter Mobile"
          />
        </div>
        <div className="mb-1">
          <input
            type="button"
            className="btn btn-success w-100"
            value="Add Mechanic"
            //onClick={(e) => addEmployee(e)}
          />
        </div>
      </div>
      <div className="col-3 col-md-3  d-none d-md-block"></div>
    </div>
  );
}
