export function EnquiryList() {
  return (
    <div className="row" style={{ marginTop: "30px" }}>
      <div className="col-3 col-md-2 d-none d-md-block"></div>
      <div className="col-12 col-md-8">
        <h3 className="alert alert-warning">Enquiry List</h3>
        <table className="table">
          <thead className="thead-dark">
            <tr>
              <th scope="col">#ID</th>
              <th scope="col">USER ID</th>
              <th scope="col">ENQUIRY_DESC</th>
              <th scope="col">ADMIN_RESPONSE</th>
            </tr>
          </thead>
        </table>
      </div>
    </div>
  );
}
