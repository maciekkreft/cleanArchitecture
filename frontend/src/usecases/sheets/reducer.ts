import { combineReducers } from "redux"

import { State } from "../../interfaces";
import { ADD_ANSWER, AddAnswerAction } from "./actions";

const byCode = (state: State.Sheets['byCode'] = {}, action: AddAnswerAction) => {
  switch (action.type) {
    case ADD_ANSWER:
      const { index, pollCode, value } = action.payload
      return {
        ...state,
        [pollCode]: {
          ...state[pollCode],
          [index]: value
        }
      }
    default:
      return state
  }
}

export default combineReducers({
  byCode
})