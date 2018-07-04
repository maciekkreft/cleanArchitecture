import { groupBy } from 'lodash'
import { combineReducers } from 'redux'

import { State } from '../../interfaces'
import * as Actions from './actions'
import normalize from './schema'

const byCode = (
  state: State.Polls['byCode'] = {},
  action: Actions.GetPollsActions
): State.Polls['byCode'] => {
  switch (action.type) {
    case Actions.GET_POLLS_RESPONSE:
      return normalize(action.payload).entities.polls
    default:
      return state
  }
}

const codes = (
  state: State.Polls['codes'] = [],
  action: Actions.GetPollsActions
): State.Polls['codes'] => {
  switch (action.type) {
    case Actions.GET_POLLS_RESPONSE:
      return normalize(action.payload).result
    default:
      return state
  }
}

export default combineReducers<State.Polls, Actions.GetPollsActions>({
  byCode,
  codes
})

export const selectPollsByCategories = (state: State.default) => {
  const polls = state.polls.codes.map(c => state.polls.byCode[c])
  return groupBy(polls, (p: State.Poll) => p.category)
}