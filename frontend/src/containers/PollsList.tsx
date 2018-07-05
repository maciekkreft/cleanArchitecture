import * as React from 'react'
import { connect } from 'react-redux'
import { Dispatch } from 'redux'

import * as Components from '../components'
import { ApiContext } from '../contexts'
import { Api, State } from '../interfaces'
import { PollsActions as Action, PollsReducer as Selector } from '../usecases'

const mapStateToProps = (state: State.default): Partial<Props> => ({
  categories: state.categories,
  polls: state.polls,
  pollsByCategories: Selector.selectPollsByCategories(state),
})

const mapDispatchToProps = (dispatch: Dispatch): Partial<Props> => ({
  getPolls: Action.getPolls(dispatch)
})

interface Props {
  api: Api
  getPolls: (api: Api) => Promise<Action.GetPollsActions>
  categories: State.Categories
  polls: State.Polls
  pollsByCategories: { [c: string]: State.Poll[] }
}

class PollsList extends React.Component<Props> {

  public componentDidMount() {
    this.props.getPolls(this.props.api)
  }

  public render() {
    return <Components.PollsList {...this.props} />
  }
}

const PollsListWithApi = (props: Props) =>
  <ApiContext.Consumer>
    {(api: Api) => <PollsList api={api} {...props} />}
  </ApiContext.Consumer>

export const PollsListContainer = connect(
  mapStateToProps,
  mapDispatchToProps
)(PollsListWithApi)
