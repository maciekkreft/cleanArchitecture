import * as React from 'react'
import { connect } from 'react-redux'
import { match as Match, withRouter } from 'react-router-dom'
import { compose, Dispatch } from 'redux'

import { PollWithSheet as PollWithSheetComponent } from '../components'
import { ApiContext } from '../contexts'
import { Api, State } from '../interfaces'
import * as Action from '../usecases/polls/actions'

const mapStateToProps = (state: State.default): Partial<Props> => ({
  pollFor: code => state.polls.byCode[code]
})

const mapDispatchToProps = (dispatch: Dispatch): Partial<Props> => ({
  getPolls: Action.getPolls(dispatch)
})

interface RouterProps {
  match: Match<{ code: string }>
  history: any
  location: any
}

interface Props {
  api: Api
  pollFor: (code: string) => State.Poll
  getPolls: (api: Api) => Promise<Action.GetPollsActions>
}

class PollWithSheet extends React.Component<Props & RouterProps> {
  public componentDidMount() {
    this.props.getPolls(this.props.api)
  }

  public render() {
    const poll = this.props.pollFor(this.props.match.params.code)
    return <PollWithSheetComponent poll={poll} />
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