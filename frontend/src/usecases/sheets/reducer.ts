import { omit } from 'lodash'
import { combineReducers } from 'redux'

import { State } from '../../interfaces'
import { ADD_ANSWER, AddAnswersAction, POST_ANSWERS_RESPONSE } from './actionCreator'

const byCode = (state: State.Sheets['byCode'] = {}, action: AddAnswersAction) => {
  switch (action.type) {
    case ADD_ANSWER:
      const { pollCode, answers } = action.payload
      const answer: { [i: number]: boolean } = answers[0]
      return {
        ...state,
        [pollCode]: {
          ...state[pollCode],
          ...answer
        }
      }
    case POST_ANSWERS_RESPONSE:
      return omit(state, action.payload.pollCode)
    default:
      return state
  }
}

export default combineReducers({
  byCode
})