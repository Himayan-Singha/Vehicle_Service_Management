const initState = {
  list: [],
  refmem: {},
};

const SERVICE_REQUEST_CREATE = "SERVICE_REQUEST_CREATE";
const REF_SERVICE_REQUEST = "REF_SERVICE_REQUEST";
const SERVICE_REQUEST_GET_ALL = "SERVICE_REQUEST_GET_ALL";
const SERVICE_CATALOG_GET_ALL = "SERVICE_CATALOG_GET_ALL";

export function createServiceRequest(payload) {
  return { type: SERVICE_REQUEST_CREATE, payload: payload };
}

export function ServiceRequestReducer(state = initState, action) {
  switch (action.type) {
    case SERVICE_REQUEST_CREATE:
      return { ...state, list: [action.payload, ...state.list] };

    case REF_SERVICE_REQUEST:
      return { ...state, refmem: action.payload };

    case SERVICE_REQUEST_GET_ALL:
      return { ...state, list: action.payload };

    case SERVICE_CATALOG_GET_ALL:
      return { ...state, list: action.payload };

    default:
      return state;
  }
}

export function getAllServiceRequest(payload) {
  //return { type: SERVICE_REQUEST_GET_ALL, payload: payload };
  return async (diapatch) => {
    const url = "http://localhost:8080/api/servicerequest/";

    const response = await fetch(url);
    const servicerequest = await response.json();

    diapatch({ type: SERVICE_REQUEST_GET_ALL, payload: servicerequest });
  };
}

export function getAllServiceCatelog(payload) {
  //return { type: SERVICE_REQUEST_GET_ALL, payload: payload };
  return async (diapatch) => {
    const url = "http://localhost:8080/api/servicecatalog/";

    const response = await fetch(url);
    const servicelist = await response.json();

    //console.log(servicelist);

    diapatch({ type: SERVICE_CATALOG_GET_ALL, payload: servicelist });
  };
}
