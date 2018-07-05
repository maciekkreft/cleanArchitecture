import * as React from 'react'

import {
  BottomNavigation,
  BottomNavigationAction,
  withStyles
} from '@material-ui/core'

import {
  Assignment as PollsIcon,
  TrendingUp as ResultsIcon
} from '@material-ui/icons'

const styles: any = {
  root: {
    bottom: 0,
    position: 'fixed',
    width: '100%',
  },
}

interface Props {
  classes: any;
}

class SimpleNavigation extends React.Component<Props, object> {
  public state = {
    value: 0,
  }

  public render() {
    const { classes } = this.props
    const { value } = this.state

    return (
      <BottomNavigation
        value={value}
        onChange={this.handleChange}
        showLabels={true}
        className={classes.root}
      >
        <BottomNavigationAction label="Ankiety" icon={<PollsIcon />} />
        <BottomNavigationAction label="Wyniki" icon={<ResultsIcon />} />
      </BottomNavigation>
    )
  }

  private handleChange = (event: any, value: any) => {
    this.setState({ value })
  }
}

export const NavigationComponent = withStyles(styles)(SimpleNavigation)