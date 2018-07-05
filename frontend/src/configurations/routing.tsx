import * as React from 'react'
import { BrowserRouter as Router, Route } from 'react-router-dom'

import * as Screens from './screens'

export default () => (
  <Router>
    <React.Fragment>
      <Route exact path="/" component={Screens.PollListScreen} />
      <Route exact path="/polls/:code" component={Screens.PollScreen} />
    </React.Fragment>
  </Router>
)