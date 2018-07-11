import * as React from 'react'
import { BrowserRouter as Router, Route } from 'react-router-dom'

import * as Screens from './screens'

export default () => (
  <Router>
    <React.Fragment>
      <Route exact path="/" component={Screens.InitScreen} />
      <Route exact path="/polls" component={Screens.PollListScreen} />
      <Route exact path="/polls/:code" component={Screens.PollScreen} />
      <Route exact path="/results/:code" component={Screens.ResultScreen} />
      <Route exact path="/results" component={Screens.ProgressScreen} />
    </React.Fragment>
  </Router>
)