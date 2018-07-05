import * as React from 'react'
import { hot } from 'react-hot-loader'
import { Provider } from 'react-redux'

import { RestApiContext } from '../dataproviders'
import Router from './routing'
import { store } from './store'

class App extends React.Component {
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

export default hot(module)(App)
