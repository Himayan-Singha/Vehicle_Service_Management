export function MechanicList() {
  return (
    <div className="row" style={{ marginTop: "30px" }}>
      <div className="col-3 col-md-2 d-none d-md-block"></div>
      <div className="col-12 col-md-8">
        <h3 className="alert alert-warning">Mechanic List</h3>
        <table className="table">
          <thead className="thead-dark">
            <tr>
              <th scope="col">#ID</th>
              <th scope="col">NAME</th>
              <th scope="col">AGE</th>
              <th scope="col">MOBILE</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
        </table>
      </div>
    </div>
  );
}
