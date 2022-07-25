import {useState} from "react";

function FileUpload() {
    const [image, setImage] = useState();
    function handleChange(e) {
        console.log(e.target.files);
        setImage(URL.createObjectURL(e.target.files[0]));
    }

    return (

        <div className="App">
            <h2>Add Image:</h2>
            <input type="file" onChange={handleChange}  />
            <img src={image} className="card-img" alt={""}/>

        </div>


    );
}
export default FileUpload;