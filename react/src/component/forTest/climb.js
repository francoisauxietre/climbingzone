import React from 'react';
import {makeStyles} from '@material-ui/core/styles';
import Fab from '@material-ui/core/Fab';
import AddIcon from '@material-ui/icons/Add';
import EditIcon from '@material-ui/icons/Edit';
import DeleteIcon from '@material-ui/icons/Delete';
import NavigationIcon from '@material-ui/icons/Navigation';

const useStyles = makeStyles(theme => ({
    fab: {
        margin: theme.spacing(1),
    },
    extendedIcon: {
        marginRight: theme.spacing(1),
    },
}));

const climbersList = [{'id': 1, 'name': 'francois', 'level': '8a', 'place': 'Rennes'},
    {'id': 1, 'name': 'francois', 'level': '8a', 'place': 'Rennes'},
    {'id': 2, 'name': 'théotime', 'level': '8b', 'place': 'Rennes'},
    {'id': 3, 'name': 'léo', 'level': '8a', 'place': 'Rennes'},
    {'id': 4, 'name': 'alma', 'level': '7b', 'place': 'Rennes'},
    {'id': 5, 'name': 'alex', 'level': '6c', 'place': 'Rennes'},
    {'id': 6, 'name': 'Elliot', 'level': '6b', 'place': 'Rennes'},
    {'id': 7, 'name': 'justin', 'level': '6c', 'place': 'Rennes'},
    {'id': 8, 'name': 'roland', 'level': '7c', 'place': 'Rennes'},
    {'id': 9, 'name': 'marie', 'level': '7a', 'place': 'Rennes'},
]


export default function FloatingActionButtons() {
    const classes = useStyles();

    return (
        <div>
            <Fab color="primary" aria-label="add" className={classes.fab}>
                <AddIcon/>
            </Fab>

            <Fab color="secondary" aria-label="edit" className={classes.fab}>
                <EditIcon/>
            </Fab>
            <Fab variant="extended" aria-label="delete" className={classes.fab}>
                <NavigationIcon className={classes.extendedIcon}/>
                Extended
            </Fab>
            <Fab disabled aria-label="delete" className={classes.fab}>
                <DeleteIcon/>
            </Fab>
        </div>
    );
}