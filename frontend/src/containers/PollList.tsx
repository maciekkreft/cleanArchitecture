import * as React from 'react'
import { connect } from 'react-redux'
import { Dispatch } from 'redux'

import * as Components from '../components'
import { ApiContext } from '../contexts'
import { Api, State } from '../interfaces'
import { PollsActions as Action, PollsReducer as Selector } from '../usecases'

const mapStateToProps = (state: State.default): Partial<Props> => ({
  pollsByCategories: Selector.selectPollsByCategories(state)
})

const mapDispatchToProps = (dispatch: Dispatch): Partial<Props> => ({
  getPolls: Action.getPolls(dispatch)
})

interface Props {
  pollsByCategories: { [c: string]: State.Poll[] }
  api: Api
  getPolls: (api: Api) => Promise<Action.GetPollsActions>
}

class PollList extends React.Component<Props> {

  public componentDidMount() {
    this.props.getPolls(this.props.api)
  }

  public render() {
    return <Components.NestedList />
  }
}

const PollListWithApi = (props: Props) =>
  <ApiContext.Consumer>
    {(api: Api) => <PollList api={api} {...props} />}
  </ApiContext.Consumer>

export const PollListContainer = connect(
  mapStateToProps,
  mapDispatchToProps
)(PollListWithApi)
