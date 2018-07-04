import { combineReducers } from 'redux'

import { State } from '../interfaces'
import { PollsReducer } from '../usecases'

export default combineReducers<State.default>({
  polls: PollsReducer.default
})