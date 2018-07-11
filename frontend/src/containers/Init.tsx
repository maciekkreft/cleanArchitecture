import * as React from 'react'
import { connect } from 'react-redux'
import { Redirect } from 'react-router-dom'
import { Dispatch } from 'redux'

import { ApiContext } from '../contexts'
import { Api, State } from '../interfaces'
import * as Action from '../usecases/init/actionCreator'

interface Props {
  api: Api
  init: (api: Api) => Promise<Action.GetInitActions>
  initialized: boolean
}

class Init extends React.Component<Props> {

  public componentDidMount() {
    this.props.init(this.props.api)
  }

  public render() {
    return (
      this.props.initialized
      && <React.Fragment>
        <Redirect to="/polls" />
      </React.Fragment>
    )
  }
}

const InitWithApi = (props: Props) =>
  <ApiContext.Consumer>
    {(api: Api) => <Init api={api} {...props} />}
  </ApiContext.Consumer>

export const InitContainer = connect(
  (state: State.default): Partial<Props> => ({
    initialized: state.initialized
  }),
  (dispatch: Dispatch): Partial<Props> => ({
    init: Action.postInit(dispatch)
  })
)(InitWithApi)