import { Dispatch } from 'redux'

import { AnswerPayload } from '../../interfaces/action';

export const ADD_ANSWER = 'ADD_ANSWER'
export type ADD_ANSWER = typeof ADD_ANSWER

export interface AddAnswer { type: ADD_ANSWER, payload: AnswerPayload }
export type AddAnswerAction = AddAnswer

export const addAnswer = (dispatch: Dispatch<AddAnswerAction>) => (payload: AnswerPayload) => {
  dispatch({ type: ADD_ANSWER, payload })
}