import {
  BottomNavigation, BottomNavigationAction, withStyles
} from '@material-ui/core'
import {
  Assignment as PollsIcon, TrendingUp as ResultsIcon
} from '@material-ui/icons'
import * as React from 'react'
import { Link, match as Match, withRouter } from 'react-router-dom'
import { compose } from 'redux'

interface StyleProps {
  classes: any
}

interface RouterProps {
  match: Match<{ code?: string }>
  history: any
  location: any
}

interface Props {
  tab: number
}

const styles: any = {
  root: {
    bottom: 0,
    position: 'fixed',
    width: '100%',
  },
}

class SimpleNavigation extends React.Component<Props & StyleProps & RouterProps, object> {

  public render() {
    const { classes, tab } = this.props
    const value = tab

    return (
      <BottomNavigation
        value={value}
        onChange={this.handleChange}
        showLabels={true}
        className={classes.root}
      >
        <BottomNavigationAction label="Ankiety"
          icon={<PollsIcon />} component={Link} to="/polls"
        />
        <BottomNavigationAction label="Wyniki"
          icon={<ResultsIcon />} component={Link} to="/results"
        />
      </BottomNavigation>
    )
  }

  private handleChange = (event: any, value: any) => {
    this.setState({ value })
  }
}

export const NavigationComponent =
  compose(
    withRouter
  )<Props & Partial<StyleProps> & RouterProps>(
    withStyles(styles)(SimpleNavigation)
  )

declare global {
  namespace JSX {
    interface IntrinsicAttributes {
      to?: string
    }
  }
}
