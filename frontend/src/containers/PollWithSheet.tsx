import * as React from 'react'
import { connect } from 'react-redux'
import { match as Match, withRouter } from 'react-router-dom'
import { compose, Dispatch } from 'redux'

import { PollWithSheet as PollWithSheetComponent } from '../components'
import { ApiContext } from '../contexts'
import { Api, Payload, State } from '../interfaces'
import * as PollActions from '../usecases/polls/actionCreator'
import * as SheetActions from '../usecases/sheets/actionCreator'

const mapStateToProps = (state: State.default): Partial<Props> => ({
  pollFor: code => state.polls.byCode[code],
  sheetFor: code => state.sheets.byCode[code],
})

const mapDispatchToProps = (dispatch: Dispatch): Partial<Props> => ({
  getPolls: PollActions.getPolls(dispatch),
  addAnswer: SheetActions.addAnswer(dispatch),
  saveAnswers: SheetActions.postAnswers(dispatch),
})

interface RouterProps {
  match: Match<{ code: string }>
  history: any
  location: any
}

interface Props {
  api: Api
  pollFor: (code: string) => State.Poll
  sheetFor: (code: string) => State.Sheet
  getPolls: (api: Api) => Promise<PollActions.GetPollsActions>
  addAnswer: (payload: Payload.Answers) => void
  saveAnswers: (api: Api) => (answers: Payload.Answers) => Promise<SheetActions.AddAnswersAction>
}

class PollWithSheet extends React.Component<Props & RouterProps> {
  public componentDidMount() {
    this.props.getPolls(this.props.api)
  }

  public render() {
    const pollCode = this.props.match.params.code
    const poll = this.props.pollFor(pollCode)
    const sheet = this.props.sheetFor(pollCode)
    const { addAnswer, saveAnswers, api } = this.props
    const save = () => saveAnswers(api)({ pollCode, answers: Object.keys(sheet).map(k => sheet[k]) })
    return <PollWithSheetComponent poll={poll} sheet={sheet} addAnswer={addAnswer} saveAnswers={save} />
  }
}

const PollWithApi = (props: Props & RouterProps) =>
  <ApiContext.Consumer>
    {(api: Api) => <PollWithSheet api={api} {...props} />}
  </ApiContext.Consumer>

export const PollWithSheetContainer =
  compose(
    withRouter,
    connect(
      mapStateToProps,
      mapDispatchToProps
    )
  )(PollWithApi)