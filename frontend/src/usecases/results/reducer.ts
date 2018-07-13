import { combineReducers } from 'redux'

import { State } from '../../interfaces'
import { GET_RESULTS_RESPONSE, GetResultsAction } from './actionCreator'
import normalize from './schema'

const byCodeAndVersion = (
  state: State.Results['byCodeAndVersion'] = {},
  action: GetResultsAction
): State.Results['byCodeAndVersion'] => {
  switch (action.type) {
    case GET_RESULTS_RESPONSE:
      return normalize(action.payload).entities.results
    default:
      return state
  }
}

export default combineReducers({
  byCodeAndVersion
})