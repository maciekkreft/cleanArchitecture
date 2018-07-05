import * as React from 'react'
import { connect } from 'react-redux'
import { Dispatch } from 'redux'

import { AppBar } from '../components'
import { ApiContext } from '../contexts'
import { Api, State } from '../interfaces'
import * as Action from '../usecases/polls/actions'
import * as Selector from '../usecases/polls/reducer'

const mapStateToProps = (state: State.default): Partial<Props> => ({
  pollByCode: Selector.selectPollByCode(state)
})

const mapDispatchToProps = (dispatch: Dispatch): Partial<Props> => ({
  getPolls: Action.getPolls(dispatch)
})

interface Props {
  api: Api
  pollByCode: { [c: string]: State.Poll }
  getPolls: (api: Api) => Promise<Action.GetPollsActions>
}

class Header extends React.Component<Props> {

  public componentDidMount() {
    this.props.getPolls(this.props.api)
  }

  public render() {
    return <AppBar pollByCode={this.props.pollByCode} />
  }
}

const HeaderWithApi = (props: Props) =>
  <ApiContext.Consumer>
    {(api: Api) => <Header api={api} {...props} />}
  </ApiContext.Consumer>

export const HeaderContainer = connect(
  mapStateToProps,
  mapDispatchToProps
)(HeaderWithApi)