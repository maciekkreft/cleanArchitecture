import { combineReducers } from 'redux'

import { State } from '../../interfaces'
import * as Actions from '../polls/actionCreator'
import normalize from '../polls/schema'

const byCode = (
  state: State.Categories['byCode'] = {},
  action: Actions.GetPollsActions
): State.Categories['byCode'] => {
  switch (action.type) {
    case Actions.GET_POLLS_RESPONSE:
      return normalize(action.payload).entities.categories
    default:
      return state
  }
}

const codes = (
  state: State.Categories['codes'] = [],
  action: Actions.GetPollsActions
): State.Categories['codes'] => {
  switch (action.type) {
    case Actions.GET_POLLS_RESPONSE:
      return Object.keys(normalize(action.payload).entities.categories)
    default:
      return state
  }
}

export default combineReducers<State.Categories, Actions.GetPollsActions>({
  byCode,
  codes
})
