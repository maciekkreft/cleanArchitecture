import { combineReducers } from 'redux'

import { State } from '../interfaces'
import {
  CategoriesReducer,
  InitializationReducer,
  PollsReducer,
  ResultsReducer,
  SheetsReducer,
  SupplementsReducer,
} from '../usecases'

export default combineReducers<State.default>({
  polls: PollsReducer.default,
  categories: CategoriesReducer.default,
  sheets: SheetsReducer.default,
  results: ResultsReducer.default,
  supplements: SupplementsReducer.default,
  initialized: InitializationReducer.default
})