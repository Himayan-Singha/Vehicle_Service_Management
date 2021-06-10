import { applyMiddleware, combineReducers } from "redux";
import { createStore } from "redux";
import { ServiceRequestReducer } from "./ServiceRequestReducer";
import thunk from "redux-thunk"; // no changes here 😀

//import { MemberReducer } from "./MemberReducer";

const rootReducer = combineReducers({
  //member: MemberReducer,
  servicerequest: ServiceRequestReducer,
});

const store = createStore(rootReducer, applyMiddleware(thunk));
export { store };
