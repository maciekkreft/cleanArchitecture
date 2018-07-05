import * as React from 'react'

import { AppBar, IconButton, Toolbar, Typography, withStyles } from '@material-ui/core'

// import { Menu } from '@material-ui/icons'

const styles = {
  flex: {
    flex: 1,
  },
  menuButton: {
    marginLeft: -12,
    marginRight: 20,
  },
  root: {
    flexGrow: 1,
  },
}

interface Props {
  classes: any;
}

function ButtonAppBar({ classes }: Props) {
  return (
    <div className={classes.root}>
      <AppBar position="static">
        <Toolbar>
          <IconButton className={classes.menuButton} color="inherit" aria-label="Menu">
            {/* <Menu /> */}
          </IconButton>
          <Typography variant="title" color="inherit" className={classes.flex}>
            JakieSuple.pl
          </Typography>
        </Toolbar>
      </AppBar>
    </div>
  )
}

export const AppBarComponent = withStyles(styles)(ButtonAppBar)