import React from 'react';
import PropTypes from 'prop-types';

Selection.propTypes = {
    onChangeSelect: PropTypes.func,
};
Selection.defaultProps = {
    onChangeSelect: null,
}

interface Props {
    onChangeSelect: any
}
function Selection(props: Props) {
    const { onChangeSelect } = props;

    function handleSelect() {
        if (onChangeSelect) {
            onChangeSelect();
        }
    }
    return (
        <select className="sl-limit" id="sl-limit" onChange={handleSelect}>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="6">6</option>
            <option value="8">8</option>
        </select>
    );
}

export default Selection;