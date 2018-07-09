import * as React from 'react'
import { connect } from 'react-redux'
import { match as Match, withRouter } from 'react-router-dom'
import { compose, Dispatch } from 'redux'

import { PollWithSheet as PollWithSheetComponent } from '../components'
import { ApiContext } from '../contexts'
import { Action, Api, State } from '../interfaces'
import * as PollActions from '../usecases/polls/actions'
import * as SheetActions from '../usecases/sheets/actions'

const mapStateToProps = (state: State.default): Partial<Props> => ({
  pollFor: code => state.polls.byCode[code],
  sheetFor: code => state.sheets.byCode[code]
})

const mapDispatchToProps = (dispatch: Dispatch): Partial<Props> => ({
  getPolls: PollActions.getPolls(dispatch),
  addAnswer: SheetActions.addAnswer(dispatch)
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
  addAnswer: (payload: Action.AnswerPayload) => void
}

class PollWithSheet extends React.Component<Props & RouterProps> {
  public componentDidMount() {
    this.props.getPolls(this.props.api)
  }

  public render() {
    const pollCode = this.props.match.params.code
    const poll = this.props.pollFor(pollCode)
    const sheet = this.props.sheetFor(pollCode)
    const { addAnswer } = this.props
    return <PollWithSheetComponent poll={poll} sheet={sheet} addAnswer={addAnswer} />
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