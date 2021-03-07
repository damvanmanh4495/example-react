import React from 'react';
import PropTypes from 'prop-types';

CategoryItem.propTypes = {
    onClickShow : PropTypes.func,

};

CategoryItem.defaultProps = {
    onClickShow: null,
}

function CategoryItem(props) {

    const { onClickShow } = props;
    const handleShow = () => {
        if( onClickShow ) {
            onClickShow();
        }
    }

    return (

            <li className="item-li" onClick={handleShow}>{props.name}</li>

    );
}

export default CategoryItem;