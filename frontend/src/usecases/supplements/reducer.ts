import { combineReducers } from 'redux'

import { State } from '../../interfaces'
import * as Actions from './actionCreator'
import normalize from './schema'

const byCode = (
  state: State.Supplements['byCode'] = {},
  action: Actions.GetSupplementsActions
): State.Supplements['byCode'] => {
  switch (action.type) {
    case Actions.GET_SUPPLEMENTS_RESPONSE:
      return normalize(action.payload).entities.supplements
    default:
      return state
  }
}

export default combineReducers({
  byCode
})