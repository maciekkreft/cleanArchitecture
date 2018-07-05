import { combineReducers } from 'redux'

import { State } from '../interfaces'
import { CategoriesReducer, PollsReducer } from '../usecases'

export default combineReducers<State.default>({
  polls: PollsReducer.default,
  categories: CategoriesReducer.default
})