import { combineReducers } from 'redux'

import { State } from '../interfaces'
import {
  CategoriesReducer,
  InitializationReducer,
  PollsReducer,
  SheetsReducer,
} from '../usecases'

export default combineReducers<State.default>({
  polls: PollsReducer.default,
  categories: CategoriesReducer.default,
  sheets: SheetsReducer.default,
  initialized: InitializationReducer.default
})