import { Dispatch } from 'redux'

import { Api, Payload } from '../../interfaces'

export const ADD_ANSWER = 'ADD_ANSWER'
export type ADD_ANSWER = typeof ADD_ANSWER

export const POST_ANSWERS_REQUEST = 'POST_ANSWERS_REQUEST'
export type POST_ANSWERS_REQUEST = typeof POST_ANSWERS_REQUEST

export const POST_ANSWERS_RESPONSE = 'POST_ANSWERS_RESPONSE'
export type POST_ANSWERS_RESPONSE = typeof POST_ANSWERS_RESPONSE

export const POST_ANSWERS_FAILURE = 'POST_ANSWERS_FAILURE'
export type POST_ANSWERS_FAILURE = typeof POST_ANSWERS_FAILURE

export interface PostAnswersRequest { type: POST_ANSWERS_REQUEST }
export interface PostAnswersResponse { type: POST_ANSWERS_RESPONSE, payload: Payload.Answers }
export interface PostAnswersFailure { type: POST_ANSWERS_FAILURE }
export interface AddAnswer { type: ADD_ANSWER, payload: Payload.Answers }

export type AddAnswersAction = AddAnswer | PostAnswersRequest
  | PostAnswersResponse | PostAnswersFailure

export const addAnswer = (dispatch: Dispatch<AddAnswersAction>) =>
  (payload: Payload.Answers) => {
    dispatch({ type: ADD_ANSWER, payload })
  }

export const postAnswers = (dispatch: Dispatch<AddAnswersAction>) => (api: Api) => (answers: Payload.Answers) => {
  dispatch({ type: POST_ANSWERS_REQUEST })
  return api.postAnswers(answers).then(
    (payload) => dispatch({ type: POST_ANSWERS_RESPONSE, payload }),
    (error) => dispatch({ type: POST_ANSWERS_FAILURE })
  )
}