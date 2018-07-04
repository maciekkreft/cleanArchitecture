import * as React from 'react'
import { connect } from 'react-redux';
import { Dispatch } from 'redux';

import * as Components from '../components';
import { Action, Api, State } from '../interfaces'

const mapStateToProps = (state: State): Partial<Props> => ({
  // pollsByCategories
})

const mapDispatchToProps = (dispatch: Dispatch): Partial<Props> => ({
  getPolls: Action.getPolls
})

interface Props {
  api: Api
  getPolls: (api: Api) => (dispatch: Dispatch) => Promise<Action.GetPollsActions>
}

class PollList extends React.Component<Props, {}> {

  public componentDidMount() {
    this.props.getPolls(this.props.api)
  }

  public render() {
    return <Components.NestedList />
  }
}

const PollListConnected = connect<Partial<Props>>(
  mapStateToProps,
  mapDispatchToProps
)(PollList)

export const PollListContainer = () =>
  <PollListConnected />