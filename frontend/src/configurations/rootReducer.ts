import { combineReducers } from 'redux'

import { State } from '../interfaces'
import {
  CategoriesReducer,
  InitializationReducer,
  PollsReducer,
} from '../usecases'

export default combineReducers<State.default>({
  polls: PollsReducer.default,
  categories: CategoriesReducer.default,
  initialized: InitializationReducer.default
})