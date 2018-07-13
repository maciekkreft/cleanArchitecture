import {
  Card, CardContent, CardHeader, List, ListItem, ListItemText, Typography, withStyles
} from '@material-ui/core'
import * as moment from 'moment'
import * as React from 'react'

import { State } from '../interfaces'

interface StyleProps {
  classes: any
}

const styles: any = {
  card: {
    marginTop: 10,
    textAlign: 'center'
  },
}

interface Props {
  classes: any
  result: State.Result
  supplements: [State.Supplement] | State.Supplement[]
}

function Result(props: Props) {
  const { classes, result, supplements = [] }: Props = props

  if (!result) {
    return null
  }

  const deficiencyLevels = {
    LOW: 'low',
    MEDIUM: 'medium',
    HIGH: 'high'
  }
  const recommendation = {
    LOW: 'You dont need supplementation',
    MEDIUM: 'You may consider supplementation',
    HIGH: 'You should consider supplementation'
  }
  const deficiencyDescription = `Your ${result.pollCode} deficiency level is ${deficiencyLevels[result.deficiency]} `
  const when = moment(result.createdAt, 'YYYY-MM-DD hh:mm:ss').fromNow()
  return (
    <div>
      <Card className={classes.card}>
        <CardHeader title={deficiencyDescription} subheader={when} />
        <CardContent>
          <Typography component='p'>{recommendation[result.deficiency]}</Typography>
        </CardContent>
      </Card>
      {
        supplements.map(s => (
          <Card key={s.code} className={classes.card}>
            <List>
              <ListItem>
                <ListItemText primary={s.name} secondary={s.dose} />
              </ListItem>
              <ListItem>
                <Typography component='p'>{s.dosing}</Typography>
              </ListItem>
            </List>
          </Card>
        ))
      }
      <br />
      <br />
      <br />
    </div>
  )
}

export const ResultComponent = withStyles(
  styles
)<Partial<StyleProps> & Props>(Result)