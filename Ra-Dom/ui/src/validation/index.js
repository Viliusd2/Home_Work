import * as yup from 'yup';

yup.setLocale({
    mixed: {
        default: 'default',
        required: (props) => ({ key: 'required', label: props.label }),
    },
    string:{
        min: (props) => ({ key: 'length', label: props.min }),
    }

});

export default yup;
