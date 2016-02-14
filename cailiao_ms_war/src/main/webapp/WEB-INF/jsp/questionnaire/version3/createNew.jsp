<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="container">
    <div class="row">
        <p class="caption">
            请按照要求创建问卷，
        </p>
        <h2 class="header" style="color: #ee6e73; font-weight: 300;">Input fields</h2>
        <p style="-webkit-font-smoothing: antialiased;">Text fields allow user input. The border should light up simply and clearly indicating which field the user is currently editing. You must have a <code class=" language-markup">.input-field</code> div wrapping your input and label. This helps our jQuery animate the label. This is only used in our Input and Textarea form elements.</p>
        <form class="col s12">
            <div class="row">
                <div class="input-field col s6">
                    <input placeholder="Placeholder" id="first_name" type="text"
                        class="validate"> <label for="first_name">First
                        Name</label>
                </div>
                <div class="input-field col s6">
                    <input id="last_name" type="text" class="validate"> <label
                        for="last_name">Last Name</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input id="password" type="password" class="validate"> <label
                        for="password">Password</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input id="email" type="email" class="validate"> <label
                        for="email">Email</label>
                </div>
            </div>
        </form>
    </div>
</div>
