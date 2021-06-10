export function Vehicle() {
  return (
    <div className="row" style={{ marginTop: "30px" }}>
      <div className="col-3 col-md-3 d-none d-md-block"></div>
      <div className="col-12 col-md-6">
        <h3 className="alert alert-warning">Register Vehicle</h3>
        <div className="alert alert-success">Vehicle Details Added</div>
        <div className="mb-1">
          <input
            type="text"
            //value={firstName}
            // onChange={(e) => updateFirstName(e)}
            className="form-control"
            placeholder="Enter User-id"
          />
        </div>
        <div className="mb-1">
          <input
            type="text"
            //value={lastName}
            // onChange={(e) => updateLastName(e)}
            className="form-control"
            placeholder="Enter vehicle color"
          />
        </div>
        <div className="mb-1">
          <input
            type="text"
            //value={userName}
            //onChange={(e) => updateUserName(e)}
            className="form-control"
            placeholder="Enter vehicle manufacturing year"
          />
        </div>
        <div className="mb-1">
          <input
            type="password"
            //value={password}
            //onChange={(e) => updatePassword(e)}
            className="form-control"
            placeholder="Enter vehicle description"
          />
        </div>
        <div className="mb-1">
          <input
            type="text"
            //value={email}
            //onChange={(e) => updateEmail(e)}
            className="form-control"
            placeholder="Enter vehicle model-id"
          />
        </div>
        <div className="mb-1">
          <input
            type="button"
            className="btn btn-success w-100"
            value="Register vehicle"
            //onClick={(e) => addEmployee(e)}
          />
        </div>
      </div>
      <div className="col-3 col-md-3  d-none d-md-block"></div>
    </div>
  );
}
