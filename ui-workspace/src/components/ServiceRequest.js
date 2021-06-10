import {
  Dropdown,
  DropdownButton,
  Form,
  FormControl,
  InputGroup,
} from "react-bootstrap";
import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useHistory } from "react-router";
import {
  createServiceRequest,
  getAllServiceCatelog,
  getAllServiceRequest,
} from "./ServiceRequestReducer";
import { ServiceRequestList } from "./ServiceRequestList";

export function ServiceRequest() {
  const state = useSelector((state) => state);
  const dispatch = useDispatch();
  const history = useHistory();
  console.log(state);

  const [successOperation, setSuccessOperation] = useState(false);
  useEffect(() => {
    dispatch(getAllServiceRequest());
    dispatch(getAllServiceCatelog());

    // const labellist = dispatch(getAllServiceRequest()).toString();
  }, []);

  const catalog = 0;
  console.log("catalog=" + catalog);

  return (
    <div className="row" style={{ marginTop: "30px" }}>
      <div className="col-3 col-md-3 d-none d-md-block"></div>
      <div className="col-12 col-md-6">
        <h3 className="alert alert-warning">Service Request</h3>
        <div className="alert alert-success">Request Registered</div>

        {/* <div className="mb-1">
          <input
            type="text"
            //value={firstName}
            // onChange={(e) => updateFirstName(e)}        vehicle registration id will have to be fetched from db(vehicle)
            className="form-control"
            placeholder="Enter vehicle registration id"
          />
        </div> */}

        {/* <div className="mb-1">
          <input
            type="text"
            //value={lastName}
            // onChange={(e) => updateLastName(e)}              price will have to be fetched from db(service catalogue)
            className="form-control"
            placeholder="Enter price"
          />
        </div> */}

        {/* <div className="mb-1">
          <input
            type="text"
            //value={userName}
            //onChange={(e) => updateUserName(e)}               mechanics id will have to be fetched from db(mechanic)
            className="form-control"
            placeholder="Enter mechanics id"
          />
        </div> */}

        <div className="form-check">
          <input
            className="form-check-input"
            type="checkbox"
            value=""
            id="defaultCheck1"
          ></input>
          <label className="form-check-label" htmlFor="defaultCheck1">
            {() => {}}
          </label>
        </div>

        <div className="mb-1">
          <input
            type="button"
            className="btn btn-success w-100"
            value="Submit Request"
            onClick={(e) => createServiceRequest(e)}
          />
        </div>
      </div>
      <div className="col-3 col-md-3  d-none d-md-block"></div>
    </div>
  );
}
