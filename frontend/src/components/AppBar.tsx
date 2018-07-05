import {
  AppBar, IconButton, Toolbar, Typography, withStyles
} from '@material-ui/core'
import { ChevronLeft as Menu } from '@material-ui/icons'
import * as React from 'react'
import { Link, match as Match, withRouter } from 'react-router-dom'
import { compose } from 'redux'

import { State } from '../interfaces';

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
  link: {
    textDecoration: 'none',
    color: 'inherit'
  }
}

interface Props {
  pollByCode: { [c: string]: State.Poll }
}

interface StyleProps {
  classes: any
}

interface RouterProps {
  match: Match<{ code?: string }>
  history: any
  location: any
}

function ButtonAppBar({ classes, match, pollByCode }: Props & StyleProps & RouterProps) {
  return (
    <div className={classes.root}>
      <AppBar position="static">
        <Toolbar>
          <IconButton className={classes.menuButton} color="inherit" aria-label="Menu">
            {
              match.params.code && pollByCode &&
              <Link to="/" className={classes.link}>
                <Menu />
              </Link>
            }
          </IconButton>
          <Typography variant="title" color="inherit" className={classes.flex}>
            {
              match.params.code && pollByCode[match.params.code]
                ? pollByCode[match.params.code].name
                : "JakieSuple.pl"
            }
          </Typography>
        </Toolbar>
      </AppBar>
    </div>
  )
}

export const AppBarComponent =
  compose(
    withRouter
  )<Props & Partial<StyleProps> & RouterProps>(
    withStyles(styles)(ButtonAppBar)
  )