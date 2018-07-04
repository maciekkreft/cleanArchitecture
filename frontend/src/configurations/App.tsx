import * as React from 'react'

import RestApiContext from './restApiContext'
import Router from './routing'

export default class App extends React.Component {
  public render() {
    return (
      <RestApiContext>
        <Router />
      </RestApiContext>
    )
  }
}
