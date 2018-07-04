import * as React from 'react'
import { Provider } from 'react-redux'

import { RestApiContext } from '../dataproviders'
import Router from './routing'
import { store } from './store'

export default class App extends React.Component {
  public render() {
    return (
      <Provider store={store}>
        <RestApiContext>
          <Router />
        </RestApiContext>
      </Provider>
    )
  }
}
